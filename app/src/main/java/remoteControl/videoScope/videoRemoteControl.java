package remoteControl.videoScope;

import android.os.Message;

import java.util.ArrayList;
import java.util.List;

import remoteControl.ICommand;
import remoteControl.IRemoteControl;
import remoteControl.noCommand;

/**
 * Created by edwinhsieh on 2014/8/28.
 */
public class videoRemoteControl implements IRemoteControl{

    ICommand mOnCommands = null;
    ICommand mOffCommands = null;
    ICommand mCaptureCommands = null;

    public videoRemoteControl(ICommand mOnCommand, ICommand mOffCommand, ICommand mCaptureCommands) {
        this.mOnCommands = mOnCommand;
        this.mOffCommands = mOffCommand;
        this.mCaptureCommands = mCaptureCommands;
    }

    @Override
    public void perform(Message msg) {

    }

    private void TurnON() {
        this.mOnCommands.execute();
    }

    private void TurnOff() {
        this.mOffCommands.execute();
    }

    private void Capture()
    {
        this.mCaptureCommands.execute();
    }

    public String toString()
    {
        StringBuffer stringBuff = new StringBuffer();
        stringBuff.append("\n------ VideoScope Remote Control -------\n");

        return stringBuff.toString();
    }


}
