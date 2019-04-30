package com.love.shortcut;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.service.quicksettings.TileService;

import java.lang.reflect.Method;

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
        collapseStatusBar(getBaseContext());
    }

    @Override
    public void onStartListening() {

    }

    @Override
    public void onStopListening() {

    }

    /**
     * 收起通知栏
     *
     * @param context
     */
    private void collapseStatusBar(Context context) {
        try {
            @SuppressLint("WrongConstant") Object statusBarManager = context.getSystemService("statusbar");
            Method collapse;
            if (Build.VERSION.SDK_INT <= 16) {
                collapse = statusBarManager.getClass().getMethod("collapse");
            } else {
                collapse = statusBarManager.getClass().getMethod("collapsePanels");
            }
            collapse.invoke(statusBarManager);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
