import java.awt.HeadlessException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

/**
 * @author sseyha
 * @date 9 តុលា 2022
 *
 */
public class StudentClient {
	public static void main(String[] args) {
		String name = "";
		String dateOfBirth = "";
		String course = "";
		if (args.length != 1) {
			System.out.println("Usag: java StudentClientRMI <host>");
			System.exit(0);
		}
		try {
			Registry registry = LocateRegistry.getRegistry("localhost");
			IRemoteStudent iRemoteStudent = (IRemoteStudent) registry.lookup("StudentServer");
			try (Scanner scanner = new Scanner(System.in)) {
				while (true) {
					System.out.print("Enter your chioce : ");
					System.out.print("1-Add		2-Search	3-SearchAll		0-Quit  : ");
					String command = scanner.nextLine();
					if ("1".equalsIgnoreCase(command)) {
						System.out.println("Enter name :");
						name = scanner.nextLine();
						System.out.println("Enter Date of birth :");
						dateOfBirth = scanner.nextLine();
						System.out.println("Enter course :");
						course = scanner.nextLine();
						Student student = new Student(name, dateOfBirth, course);
						iRemoteStudent.save(student);
					} else if ("2".equalsIgnoreCase(command)) {

					} else if ("3".equalsIgnoreCase(command)) {

					} else if ("0".equalsIgnoreCase(command)) {
						break;
					} else {
						continue;
					}

				}
			}

		} catch (

		Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	private static String retStr(int iRet) {
		return iRet != 0 ? "Sucessful" : "Failed";
	}
}
