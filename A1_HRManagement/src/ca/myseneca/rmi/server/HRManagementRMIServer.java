package ca.myseneca.rmi.server;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/*
 * @author : Anaswara Naderi Vadakkeperatta
 * 			 Jonathan Chik
 * 
 * 			 This class is the RMI server program to create RMI registry service.
 */

public class HRManagementRMIServer {

	public static void main(String[] args) {
		try {

			// Creating object for the DAManager
			DAInterface DAObject = new DAInterfaceImpl();

			// Creating registry service with default port number
			LocateRegistry.createRegistry(1099);

			// Bind the calculator Object instance to the server
			Naming.rebind("rmi://localhost:1099/HRManagementServer", DAObject);

			System.out.println("Connected to registry!");

		} catch (RemoteException | MalformedURLException e) {
			e.printStackTrace();
		}
	}

}
