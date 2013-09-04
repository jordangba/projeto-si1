package AcceptTest.Simulator;

import java.util.ArrayList;
import java.util.List;

import easyaccept.EasyAcceptFacade;

public class RunTestAccept {
	public static void main(String[] args) throws Exception {
		testCreateAcount();
	}

	private static void testCreateAcount() {
		List<String> files = new ArrayList<String>();

		files.add("src/AcceptTest/CreateAcount/US01.txt");
		files.add("src/AcceptTest/CreateAcount/US02.txt");
		files.add("src/AcceptTest/CreateAcount/US03.txt");
		files.add("src/AcceptTest/CreateAcount/US04.txt");
		// files.add("src/AcceptTest/CreateAcount/US05.txt");

		CreateAcountSimulator fachada = new CreateAcountSimulator();

		EasyAcceptFacade eaFacade = new EasyAcceptFacade(fachada, files);

		eaFacade.executeTests();

		System.out.println(eaFacade.getCompleteResults());
	}
}
