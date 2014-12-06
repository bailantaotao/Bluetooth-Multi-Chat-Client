package remoteControl.videoScope;

import remoteControl.ICommand;

/**
 * Created by edwinhsieh on 2014/9/11.
 */
public class videoCaptureCommand implements ICommand {
    public videoScope mVideoScope;

    public videoCaptureCommand(videoScope mVideoScope) {
        this.mVideoScope = mVideoScope;
    }

    @Override
    public void execute() {
        this.mVideoScope.capture();
    }
}
