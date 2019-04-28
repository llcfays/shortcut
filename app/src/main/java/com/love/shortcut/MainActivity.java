package com.love.shortcut;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;

import static com.love.shortcut.RootUtils.runRootCommand;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        runRootCommand(" am start -n com.miui.voiceassist/com.xiaomi.voiceassistant.AiSettings.AiShortcutActivity -a action.intent.action.VIEW");
        finish();
    }

    private void onHideIcon() {
        PackageManager p = getPackageManager();
        p.setComponentEnabledSetting(getComponentName(), PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP);
    }


}
