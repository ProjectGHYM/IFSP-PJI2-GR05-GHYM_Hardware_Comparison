package Controller;

import View.*;
import Model.*;
import Model.DAO.DB;

public class Inicializador 
{
	public static void main(String[] args) 
	{
		long id;

		EntradaSistema exibi = new EntradaSistema();
		DB bd = new DB();

		id = exibi.leID();

		if(bd.verificacao(id))
			exibi.hiSystem();
		else
			exibi.IDIncorreto();
	}
}
