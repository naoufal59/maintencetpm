package com.javadev.maintencetpm.controlleur;

import java.io.IOException;
import java.util.Calendar;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javadev.maintencetpm.dto.AnomalieDTO;
import com.javadev.maintencetpm.dto.DataPointModelDTO;
import com.javadev.maintencetpm.dto.EquipementDTO;
import com.javadev.maintencetpm.dto.MaintenaceDTO;
import com.javadev.maintencetpm.dto.PreventiveDTO;
import com.javadev.maintencetpm.dto.SolutionDTO;
import com.javadev.maintencetpm.service.AnomalieService;
import com.javadev.maintencetpm.service.DataPointModelService;
import com.javadev.maintencetpm.service.EquipementService;
import com.javadev.maintencetpm.service.MaintenanceService;
import com.javadev.maintencetpm.service.PreventiveService;
import com.javadev.maintencetpm.service.SolutionService;
import com.javadev.maintencetpm.service.impl.AnomalieServiceImpl;
import com.javadev.maintencetpm.service.impl.CanvasjsChartService;
import com.javadev.maintencetpm.service.impl.DataPointModelImpl;
import com.javadev.maintencetpm.service.impl.EquipementServiceImpl;
import com.javadev.maintencetpm.service.impl.MaintenanceServiceImpl;
import com.javadev.maintencetpm.service.impl.PreventiveServiceImpl;
import com.javadev.maintencetpm.service.impl.SolutionServiceImpl;
import com.javadev.maintencetpm.utiluri.UtilUri;

@Controller
//@RequestMapping(value = UtilUri.admin)
public class AdminControlleur {
	
	
	private EquipementService EquipemetService;
	
	private AnomalieService anomalieService;

	private PreventiveService preventiveService;
	
	private CanvasjsChartService canvasjsChartService;
	
	private SolutionService solutionService;

	private DataPointModelService dataPointModelService;
	
	private MaintenanceService maintenanceService;
	
	@Autowired
	public AdminControlleur() {
		EquipemetService      = new EquipementServiceImpl();
		anomalieService  	  = new AnomalieServiceImpl();
		preventiveService	  = new PreventiveServiceImpl();
		solutionService  	  = new SolutionServiceImpl();
		dataPointModelService = new DataPointModelImpl();
		maintenanceService    = new MaintenanceServiceImpl();
	}

	Map<String, Double> canvasjsDataList;
	Map<String, Double> canvasjsDataListMTRF;
	Map<String, Double> canvasjsDataListdispo;

	public static Boolean isGotSomthing = false;
	public PreventiveDTO pr;
	public AnomalieDTO anomalie;
	public MaintenaceDTO Maintenace;
	private int weekOfYear;

	public int getWeekOfYear() {
		return weekOfYear;
	}

	public void setWeekOfYear(int weekOfYear) {
		this.weekOfYear = weekOfYear;
	}

	
	@RequestMapping(value = UtilUri.index)
	public String home(Model model, @RequestParam(name = "code", defaultValue = "-1") Long code) {
		model.addAttribute("Maintenace", new MaintenaceDTO());

		if (code == -1)
			model.addAttribute("Maintenaces", maintenanceService.listMaintenance());
		else {
			EquipementDTO ty = new EquipementDTO();
			ty.setId(code);
			model.addAttribute("Maintenaces", maintenanceService.findByEquipement(ty));
		}
		model.addAttribute("equipemts", EquipemetService.findAllEquipement());
		return "Maintenace";
	}

	@RequestMapping(value = UtilUri.saveMaintenace, method = RequestMethod.POST)
	public String save(MaintenaceDTO p, Model model, @RequestParam(name = "code", defaultValue = "-1") Long code,
			@RequestParam(name = "Etat") Boolean Etat) throws IOException {
		p.setEtat(Etat);
		maintenanceService.ajouterMainteance(p, code);
		if (p.getEtat().equals(false)) {
			isGotSomthing = true;
		}
		model.addAttribute("Maintenace", new MaintenaceDTO());
		model.addAttribute("Maintenaces", maintenanceService.listMaintenance());
		model.addAttribute("equipemts", EquipemetService.findAllEquipement());
		return "redirect:/admin/index";
	}

	@RequestMapping(value = UtilUri.valideMaintenace)
	public String valide(Long id) {
		maintenanceService.validMaintenceDTO(id);
		return "redirect:/admin/index";
	}

	@RequestMapping(value = UtilUri.rejetMaintenace)
	public String rejet(Long id) {
		maintenanceService.rejectMaintenceDTO(id);
		isGotSomthing = true;
		return "redirect:/admin/index";
	}


	@RequestMapping(value = UtilUri.getVedio)
	public String Vedio(Model model) {
		System.out.println(isGotSomthing);
		model.addAttribute("isGotSomthing", isGotSomthing);
		return "vedio";
	}

	
	@RequestMapping(value = UtilUri.anomalie)
	public String anomalie(Model model, @RequestParam(name = "code", defaultValue = "-1") Long code) {
		model.addAttribute("anomalie", new AnomalieDTO());

		if (code == -1)
			model.addAttribute("anomalies", anomalieService.getAll());
		else {
			EquipementDTO ty = new EquipementDTO();
			ty.setId(code);
			model.addAttribute("anomalies", anomalieService.findByEquipementAnomalie(ty));
		}
		model.addAttribute("equipemts", EquipemetService.findAllEquipement());
		return "anomalie";
	}

	@RequestMapping(value = UtilUri.saveanomalie, method = RequestMethod.POST)
	public String saveanomalie(AnomalieDTO p, Model model, @RequestParam(name = "code", defaultValue = "-1") Long code,
			@RequestParam(name = "typeAnomalie") String Etat) throws IOException {
		p.setTypeAnomalie(Etat);
		anomalieService.ajouterAnomalie(p, code);
		isGotSomthing = true;
		model.addAttribute("anomalie", new AnomalieDTO());
		model.addAttribute("anomalies", anomalieService.getAll());
		model.addAttribute("equipemts", EquipemetService.findAllEquipement());
		return "redirect:/admin/anomalie";
	}

	
	@RequestMapping(value = UtilUri.tech)
	public String tech(Model model) {
		System.out.println(isGotSomthing);
		model.addAttribute("Maintenace", new MaintenaceDTO());
		model.addAttribute("chasesAnomalie", anomalieService.inValideAnomalie());
		model.addAttribute("preventiveAction", preventiveService.getAll());
		model.addAttribute("inValidMaintemnace", maintenanceService.inValideMaintenace());
		return "tech";
	}

	@RequestMapping(value = UtilUri.solutionMaintenance)
	public String solutionMaintenance(Long id, Model model) {
		model.addAttribute("solution", new SolutionDTO());
		Maintenace = maintenanceService.getMaintence(id);
		return "solutionMa";
	}

	@RequestMapping(value = UtilUri.GotoTheTable)
	public String GotoTheTable(SolutionDTO c) {
		maintenanceService.GotoTheTable(Maintenace.getIdMaintenace());
		c.setMaintenace(Maintenace);
		solutionService.addSolutionMaintenance(c, Maintenace.getIdMaintenace());
		return "redirect:/admin/tech";
	}

	@RequestMapping(value = UtilUri.solutionAnomalie)
	public String solutionAnomalie(Long id, Model model) {
		model.addAttribute("solution", new SolutionDTO());
		try {
			anomalie = anomalieService.getById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "solutionAn";
	}

	@RequestMapping(value = UtilUri.GotoTheTableAnomalie)
	public String GotoTheTableAnomalie(SolutionDTO c) {
		anomalieService.GotoTheTableAnomalie(anomalie.getIdAnomalie());
		c.setAnomalie(anomalie);
		solutionService.addSolutionAnomalie(c, anomalie.getIdAnomalie());
		return "redirect:/admin/tech";
	}

	@RequestMapping(value = UtilUri.solutionPreventive)
	public String solutionPreventivr(Long id, Model model) {
		model.addAttribute("solution", new SolutionDTO());
		try {
			pr = preventiveService.getById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "solution";
	}

	@RequestMapping(value = UtilUri.GotoTheTablepreventive)
	public String GotoTheTablepreventivr(SolutionDTO c) {
		preventiveService.GotoTheTablepreventivr(pr.getIdPreventive());
		c.setPreventive(pr);
		solutionService.addSolution(c, pr.getIdPreventive());
		return "redirect:/admin/tech";
	}

	@RequestMapping(value = UtilUri.preventive)
	public String preventive(Model model, @RequestParam(name = "code", defaultValue = "-1") Long code) {
		model.addAttribute("preventive", new PreventiveDTO());

		if (code == -1)
			model.addAttribute("preventives", preventiveService.getAll());
		else {
			EquipementDTO ty = new EquipementDTO();
			ty.setId(code);
			model.addAttribute("preventives", preventiveService.findByEquipementPreventive(ty));
		}
		model.addAttribute("equipemts", EquipemetService.findAllEquipement());
		return "preventive";
	}

	@RequestMapping(value = UtilUri.savepreventive, method = RequestMethod.POST)
	public String savepreventive(PreventiveDTO p, Model model,
			@RequestParam(name = "code", defaultValue = "-1") Long code, @RequestParam(name = "action") String action)
			throws IOException {
		Calendar cal = Calendar.getInstance();
		p.setAction(action);
		preventiveService.create(p, code);
		int ordinalDay = cal.get(Calendar.DAY_OF_YEAR);
		int weekDay = cal.get(Calendar.DAY_OF_WEEK) - 1; // Sunday = 0
		int numberOfWeeks = (ordinalDay - weekDay + 10) / 7;
		System.out.println(numberOfWeeks);
		System.out.println(p.getNb_Somaime());
		if (p.getNb_Somaime().equals("" + numberOfWeeks)) {
			isGotSomthing = true;
		}
		model.addAttribute("preventive", new PreventiveDTO());
		model.addAttribute("preventives", preventiveService.getAll());
		model.addAttribute("equipemts", EquipemetService.findAllEquipement());
		return "redirect:/admin/preventive";
	}

	
	@RequestMapping(value = UtilUri.Statistiques)
	public String kpsValue(ModelMap model, @RequestParam(name = "code", defaultValue = "-1") Long code) {
		canvasjsDataList = canvasjsChartService.getCanvasjsChartData();
		canvasjsDataListMTRF = canvasjsChartService.getCanvasjsChartDataMTRF();
		canvasjsDataListdispo = canvasjsChartService.getCanvasjsChartDataDispo();
		if (code == -1) {
			model.addAttribute("surveyMapdispo", canvasjsDataListdispo);
			model.addAttribute("surveyMapMtrf", canvasjsDataListMTRF);
			model.addAttribute("surveyMap", canvasjsDataList);
		} else {
			EquipementDTO ty = new EquipementDTO();
			ty.setId(code);
			model.addAttribute("surveyMapdispo", canvasjsChartService.getCanvasjsChartDataDispoChercher(ty));
			model.addAttribute("surveyMapMtrf", canvasjsChartService.getCanvasjsChartDataMTRFChercher(ty));
			model.addAttribute("surveyMap", canvasjsChartService.getCanvasjsChartDataChercher(ty));
		}
		model.addAttribute("equipemts", EquipemetService.findAllEquipement());
		model.addAttribute("Kpi", new DataPointModelDTO());
		return "kpi";
	}

	@RequestMapping(value = UtilUri.saveMtr, method = RequestMethod.POST)
	public String saveMtr(DataPointModelDTO p, Model model, @RequestParam(name = "code", defaultValue = "-1") Long code)
			throws IOException {

		dataPointModelService.ajouterMttr(p, code);

		model.addAttribute("surveyMapdispo", canvasjsDataListdispo);
		model.addAttribute("surveyMapMtrf", canvasjsDataListMTRF);
		model.addAttribute("surveyMap", canvasjsDataList);
		model.addAttribute("equipemts", EquipemetService.findAllEquipement());
		model.addAttribute("Kpi", new DataPointModelDTO());
		return "redirect:/admin/kpi";
	}
}
