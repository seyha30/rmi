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
		int id;
		String name = "";
		String dateOfBirth = "";
		String course = "";
//		if (args.length != 1) {
//			System.out.println("Usag: java StudentClientRMI <host>");
//			System.exit(0);
//		}
		try {
			Registry registry = LocateRegistry.getRegistry("localhost");
			IRemoteStudent iRemoteStudent = (IRemoteStudent) registry.lookup("StudentServer");
			try (Scanner scanner = new Scanner(System.in)) {
				while (true) {
					System.out.print("Enter your chioce : ");
					System.out.print("1: Save, 2: Update, 3: Delete, 4: FindAll, 5: FindById, 6: FindByName, 7: FindByCourse, 	0-Quit  : ");
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
						System.out.println("Enter id :");
						id = scanner.nextInt();
						System.out.println("Enter name :");
						name = scanner.nextLine();
						System.out.println("Enter Date of birth :");
						dateOfBirth = scanner.nextLine();
						System.out.println("Enter course :");
						course = scanner.nextLine();
						Student student = new Student(name, dateOfBirth, course);
						iRemoteStudent.update(student);
					} else if ("3".equalsIgnoreCase(command)) {
						System.out.println("Enter id :");
						id = scanner.nextInt();
						iRemoteStudent.delete(id);
					} else if ("4".equalsIgnoreCase(command)) {
						iRemoteStudent.findAll();
					} else if ("5".equalsIgnoreCase(command)) {
						System.out.println("Enter id :");
						id = scanner.nextInt();
						iRemoteStudent.findById(id);
					} else if ("6".equalsIgnoreCase(command)) {
						System.out.println("Enter name :");
						name = scanner.nextLine();
						iRemoteStudent.findByName(name);
					} else if ("7".equalsIgnoreCase(command)) {
						System.out.println("Enter course :");
						course = scanner.nextLine();
						iRemoteStudent.findByCourse(course);
					} else if ("0".equalsIgnoreCase(command)) {
						break;
					} else {
						continue;
					}

				}
			}

		} catch (

		Exception e) {
			e.printStackTrace();
		}

	}
}
