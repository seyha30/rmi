import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * @author sseyha
 * @date 9 តុលា 2022
 * 
 */
public interface IRemoteProvince {
	public int save(Province p) throws RemoteException;

	public int update(Province p) throws RemoteException;

	public ArrayList<Province> findAll() throws RemoteException;

	public ArrayList<Province> findByName(String criteria) throws RemoteException;

	public int deleteAll() throws RemoteException;
}
