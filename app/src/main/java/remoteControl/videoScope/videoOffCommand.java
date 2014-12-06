package remoteControl.videoScope;

import remoteControl.ICommand;

/**
 * Created by edwinhsieh on 2014/8/28.
 */
public class videoOffCommand implements ICommand {
    public videoScope mVideoScope;

    public videoOffCommand(videoScope mVideoScope) {
        this.mVideoScope = mVideoScope;
    }

    @Override
    public void execute() {
        this.mVideoScope.off();
    }
}
