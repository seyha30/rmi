import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * @author sseyha
 * @date 9 តុលា 2022
 *
 */
public interface IRemoteStudent extends Remote {
	public void save(Student student) throws RemoteException;
	public void update(Student student) throws RemoteException;
	public void delete(int id) throws RemoteException;
	public ArrayList<Student> findAll() throws RemoteException;
	public Student findById(int id) throws RemoteException ;
	public ArrayList<Student> findByName(String criteria) throws RemoteException;
}
