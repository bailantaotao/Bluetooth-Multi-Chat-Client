package remoteControl;

import remoteControl.videoScope.videoCaptureCommand;
import remoteControl.videoScope.videoOffCommand;
import remoteControl.videoScope.videoOnCommand;
import remoteControl.videoScope.videoRemoteControl;
import remoteControl.videoScope.videoScope;

/**
 * Created by edwinhsieh on 2014/9/12.
 */
public class deviceFactory {

    public static final int TYPE_VIDEOSCOPE = 0;

    public static IRemoteControl createDevice(final int mDeviceType)
    {
        IRemoteControl device = null;
        if(mDeviceType == TYPE_VIDEOSCOPE) {
            return CreateVideoScope();
        }

        return null;
    }

    private static IRemoteControl CreateVideoScope()
    {
        videoScope mVideoScope = new videoScope();
        ICommand turnOn = new videoOnCommand(mVideoScope);
        ICommand turnOff = new videoOffCommand(mVideoScope);
        ICommand capture = new videoCaptureCommand(mVideoScope);
        return new videoRemoteControl(turnOn, turnOff, capture);
    }
}
