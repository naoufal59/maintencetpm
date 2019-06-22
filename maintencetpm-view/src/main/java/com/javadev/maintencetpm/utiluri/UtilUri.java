package com.javadev.maintencetpm.utiluri;

public interface UtilUri {
	static String admin 			    = "/admin";
	static String index 			    = "/index";
	// uri for maintence 
	static String saveMaintenace 	    = "/save";
	static String valideMaintenace      = "/Valider";
	static String rejetMaintenace       = "/rejet";
	static String solutionMaintenance   = "/solutionMaintenance";
	static String GotoTheTable  	    = "/GotoTheTable";
	
	// uri for vedio 
	static String getVedio              = "/Vedio";
	
	// uri for Anomalie
	static String anomalie 		        = "/anomalie";
	static String saveanomalie 		    = "/saveanomalie";
	static String solutionAnomalie      = "/solutionAnomalie";
	static String GotoTheTableAnomalie  = "/GotoTheTableAnomalie";
	
	// Tech
    static String tech				    = "/tech";
	
    //uri for Preventive
    static String preventive 			= "/preventive";
    static String savepreventive 	    = "/savepreventive";
    static String solutionPreventive    = "/solutionPreventivr";
    static String GotoTheTablepreventive= "/GotoTheTablepreventivr";
    
    // Statistiques
    static String Statistiques 			= "/kpi";
    static String saveMtr 				= "/saveMtr";
    
}
