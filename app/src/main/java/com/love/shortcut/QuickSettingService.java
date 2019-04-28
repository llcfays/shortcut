package com.love.shortcut;

import android.annotation.TargetApi;
import android.os.Build;
import android.service.quicksettings.TileService;

import static com.love.shortcut.RootUtils.runRootCommand;

/**
 * <pre>
 *     @author : h.yw
 *     @e-mail : h-yw@outlook.com
 *     @time   : 2019/04/26
 *     @desc   :
 *     @version: 1.0
 * </pre>
 */
@TargetApi(Build.VERSION_CODES.N)
public class QuickSettingService extends TileService {


    @Override
    public void onTileAdded() {
    }

    @Override
    public void onTileRemoved() {
    }

    @Override
    public void onClick() {
        runRootCommand(" am start -n com.miui.voiceassist/com.xiaomi.voiceassistant.AiSettings.AiShortcutActivity -a action.intent.action.VIEW");
    }

    @Override
    public void onStartListening() {

    }

    @Override
    public void onStopListening() {

    }
}
