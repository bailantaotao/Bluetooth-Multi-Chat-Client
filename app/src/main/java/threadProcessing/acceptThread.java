package threadProcessing;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothServerSocket;
import android.bluetooth.BluetoothSocket;

import java.io.IOException;

import observer.ICommunicationListener;
import observer.IConnectionListener;
import utility.metadataBT;

/**
 * Created by edwinhsieh on 2014/8/19.
 */
public class acceptThread extends AbstractThread {


    // The local server socket
    private final BluetoothServerSocket mmServerSocket;
    private String mSocketType;
    public boolean AcceptClient = false;

    public acceptThread(boolean secure, BluetoothAdapter mAdapter, IConnectionListener callbacksBTFunction, ICommunicationListener callbacksData) {
        super(connectedThread.class.getSimpleName(), callbacksBTFunction, callbacksData);
        BluetoothServerSocket tmp = null;
        mSocketType = secure ? "Secure" : "Insecure";

        // Create a new listening server socket
        try {
            if (secure) {
                tmp = mAdapter.listenUsingRfcommWithServiceRecord(metadataBT.NAME_SECURE, metadataBT.MY_UUID_SECURE);
            }
            else {
                tmp = mAdapter.listenUsingInsecureRfcommWithServiceRecord(metadataBT.NAME_INSECURE, metadataBT.MY_UUID_INSECURE);
            }
        } catch (IOException e) {
            Loge("Socket Type: " + mSocketType + "listen() failed" + e);
            errorCallback(AcceptThread_CHANNEL, MSG_SOCKET_LISTEN_ERROR, null, "Socket Type: " + mSocketType + " listen() failed " + e.toString());
        }
        mmServerSocket = tmp;
    }

    public void run() {
        Logd("Socket Type: " + mSocketType + "BEGIN mAcceptThread" + this);

        setName("AcceptThread" + mSocketType);

        BluetoothSocket socket = null;

        // Listen to the server socket if we're not connected
        while (AcceptClient) {
            try {
                // This is a blocking call and will only return on a
                // successful connection or an exception
                    socket = mmServerSocket.accept();
                    if(socket != null)
                    {
                        String address = socket.getRemoteDevice().getAddress();
                        if(callbacksBTFunction!=null)
                            callbacksBTFunction.connected(socket, socket.getRemoteDevice(), mSocketType);

                    }
            } catch (IOException e) {
                Loge("Socket Type: " + mSocketType + "accept() failed" + e);
                errorCallback(AcceptThread_CHANNEL, MSG_SOCKET_ACCEPT_ERROR, null, "Socket Type: " + mSocketType + " accept() failed " + e);
                break;
            }
            Logd("END mAcceptThread, socket Type: " + mSocketType);
        }

    }

    public void cancel() {
        Logd("Socket Type" + mSocketType + "cancel " + this);
        AcceptClient = false;
        try {
            mmServerSocket.close();
        } catch (IOException e) {
            Logd("Socket Type" + mSocketType + "close() of server failed" + e);
            errorCallback(AcceptThread_CHANNEL, MSG_SOCKET_CLOSE_ERROR, null, "Socket Type" + mSocketType + "close() of server failed" + e);
        }
    }
}
