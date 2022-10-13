import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 * @author sseyha
 * @date 9 តុលា 2022
 *
 */
public class StudentServer extends UnicastRemoteObject implements IRemoteStudent {
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		try {
			LocateRegistry.createRegistry(1099);
			StudentServer studentServer = new StudentServer();
			Naming.rebind("ProvinceServer", studentServer);
			System.out.println("ProvinceServer is created!!!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @throws RemoteException
	 */
	protected StudentServer() throws RemoteException {
		super();
	}

	@Override
	public void save(Student student) throws RemoteException {
		StudentRepository.save(student);
	}

	@Override
	public void update(Student student) throws RemoteException {
		StudentRepository.update(student);
	}

	@Override
	public ArrayList<Student> findAll() throws RemoteException {
		return StudentRepository.findAll();
	}

	@Override
	public ArrayList<Student> findByName(String criteria) throws RemoteException {
		return StudentRepository.findByName(criteria);
	}
	@Override
	public Student findById(int id) throws RemoteException {
		return StudentRepository.findById(id);
	}

	@Override
	public void delete(int id) throws RemoteException {
		StudentRepository.delete(id);
	}

}
