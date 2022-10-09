import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 * @author sseyha
 * @date 9 តុលា 2022
 *
 */
public class StudentServer extends UnicastRemoteObject implements IRemoteStudent {

	/**
	 * @throws RemoteException
	 */
	protected StudentServer() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int save(Student p) throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Student p) throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteAll() throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<Student> findAll() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Student> findByName(String criteria) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
