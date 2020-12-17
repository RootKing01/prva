package controller;

import demoGui.Home;
import demoGui.LoginFrameMenager;

public class ControllerGrafica1 {
	
	public LoginFrameMenager paginaLogin;
	public Home paginaHome;
	
	
	
	public ControllerGrafica1() 
	{
		
		paginaLogin = new LoginFrameMenager(this);
		paginaLogin.setVisible(false);
		
		paginaHome = new Home(this);
		paginaHome.setVisible(false);

	}
	
	public static void main(String[] args) 
	{
		ControllerGrafica1 controller = new ControllerGrafica1();
		controller.paginaLogin.setVisible(true);
		
	}

	
	
	
	public void controlloCredenziali(String email, String password) 
	{
		System.out.println("ecco "+email+ " "+ password);
		if(controlloPassword() && controlloEmail()) 
		{
			paginaLogin.setVisible(false);
			paginaHome.setVisible(true);
		}	
	}

	private boolean controlloEmail() 
	{
		// TODO Auto-generated method stub
		// metodo nella classe StudenteDao
		return true;
	}

	private boolean controlloPassword() 
	{
		// TODO Auto-generated method stub
		// medoto nella classe StudenteDao
		return true;
	}
}
