package observer;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;

/**
 * Created by edwinhsieh on 2014/8/19.
 */
public interface IConnectionListener {
    public void connected(BluetoothSocket socket, BluetoothDevice device, final String socketType);
    public void connect(BluetoothDevice device);
}
