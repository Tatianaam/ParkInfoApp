package com.techelevator.npgeek;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.security.sasl.SaslException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.converter.feed.AtomFeedHttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.techelevator.npgeek.model.Park;
import com.techelevator.npgeek.model.SurveyResult;
import com.techelevator.npgeek.model.Weather;
import com.techelevator.npgeek.model.jdbc.JDBCParkDAO;
import com.techelevator.npgeek.model.jdbc.JDBCSurveyResultDAO;
import com.techelevator.npgeek.model.jdbc.JDBCWeatherDAO;


@Controller
public class NationalParkController {
	
	@Autowired
	private JDBCParkDAO parkDAO;
	@Autowired
	private JDBCSurveyResultDAO surveyResultDAO;
	@Autowired
	private JDBCWeatherDAO weatherDAO;

	@RequestMapping(path = "/", method = RequestMethod.GET)
	public String showHomePage(ModelMap map) {
		
		List<Park> parks = parkDAO.getAllParks();
		map.addAttribute("parks", parks);
		
		return "homePage";
	}
	
	@RequestMapping(path = "/parkDetails", method = RequestMethod.GET)
	public String showParkDetailsPage(HttpServletRequest request, ModelMap map, HttpSession session) {
		
		String selectedParkCode = request.getParameter("parkcode");

		map.addAttribute("park", parkDAO.getParkByCode(selectedParkCode));
		
		//true is F     false is C
		boolean scalePreference = true;

		if (session.getAttribute("scalePreference") == null) {
			session.setAttribute("scalePreference", scalePreference);
		} else {
			scalePreference = (boolean)session.getAttribute("scalePreference");
		}					
		
		List<Weather> forecasts = weatherDAO.getWeatherByCode(selectedParkCode, scalePreference);
		
		map.addAttribute("forecasts", forecasts);
		
		return "parkDetails";
	}
	
	@RequestMapping(path = "/parkDetails", method = RequestMethod.POST)
	public String processPreference(HttpSession session, 
			@RequestParam (defaultValue="true")String preference, 
			@RequestParam String parkCode) {
		
		if (preference.equalsIgnoreCase("true")) {
			session.setAttribute("scalePreference", true);
		} else {
			session.setAttribute("scalePreference", false);
		}
		
		return "redirect:/parkDetails?parkcode="+parkCode;
	}
	
	@RequestMapping(path = "/surveyInput", method = RequestMethod.GET)
	public String showSurveyPage(Model map) {
		
		if (!map.containsAttribute("surveyResult")) {
			map.addAttribute("surveyResult", new SurveyResult());
		}
		
		map.addAttribute("parks", parkDAO.getAllParks());
			
		return "surveyInput";
	}

	@RequestMapping(path = "/surveyInput", method = RequestMethod.POST)
	public String processSpaceForumInput(@Valid @ModelAttribute("surveyResult") SurveyResult surveyFormValues,
			BindingResult result, RedirectAttributes flash) {
		
		//validation piece here
		if (result.hasErrors()) {
			flash.addFlashAttribute("surveyResult", surveyFormValues);
			flash.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "surveyResult", result);
			return "redirect:/surveyInput";
		}

		surveyResultDAO.addSurveyResultToDatabase(surveyFormValues);
	

		return "redirect:/favoriteParks";
	}
	@RequestMapping(path = "/favoriteParks", method = RequestMethod.GET)
	public String showSurveyResult(ModelMap map) {

		Map<String, Integer> favorites =surveyResultDAO.getCodesAndVotes();
		List<Park> parks = new ArrayList<Park>();
		//List<Integer> votes = new ArrayList<>();
		
		for (Map.Entry<String, Integer> entry : favorites.entrySet()) {
			parks.add(parkDAO.getParkByCode(entry.getKey()));
		//	votes.add(entry.getValue());
		}
		
		map.addAttribute("parks", parks);
		map.addAttribute("favorites", favorites);

		return "favoriteParks";
	}

}
