import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * @author sseyha
 * @date 9 តុលា 2022
 *
 */
public interface IRemoteStudent extends Remote {
	public int save(Student p) throws RemoteException;

	public int update(Student p) throws RemoteException;

	public ArrayList<Student> findAll() throws RemoteException;

	public ArrayList<Student> findByName(String criteria) throws RemoteException;

	public int deleteAll() throws RemoteException;
}
