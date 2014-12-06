package remoteControl.videoScope;

import remoteControl.ICommand;

/**
 * Created by edwinhsieh on 2014/8/28.
 */
public class videoOnCommand implements ICommand {

    videoScope mVideoScope;

    public videoOnCommand(videoScope mVideoScope) {
        this.mVideoScope = mVideoScope;
    }

    @Override
    public void execute() {
        this.mVideoScope.on();
    }
}
