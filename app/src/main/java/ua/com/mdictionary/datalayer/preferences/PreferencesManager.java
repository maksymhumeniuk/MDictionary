package ua.com.mdictionary.datalayer.preferences;

import android.content.SharedPreferences;

public class PreferencesManager {

    private static final String SELECTED_IDS = "selected_ids";
    private SharedPreferences sharedPreferences;

    public PreferencesManager(SharedPreferences sharedPreferences) {
        this.sharedPreferences = sharedPreferences;
    }

   /* public void saveSelectedId(String id) {
        Set<String> selectedObjects = getSelectedIds();
        selectedObjects.add(id);
        sharedPreferences.edit().putStringSet(SELECTED_IDS, selectedObjects).apply();
    }

    public Set<String> getSelectedIds() {
        return sharedPreferences.getStringSet(SELECTED_IDS, new HashSet<>());
    }

    public void clearSelectedIds() {
        sharedPreferences.edit().putStringSet(SELECTED_IDS, new HashSet<>()).apply();
    }

    public void removeUnselectedId(String id) {
        Set<String> selectedIds = getSelectedIds();
        if (selectedIds.contains(id)) {
            selectedIds.remove(id);
        }
        sharedPreferences.edit().putStringSet(SELECTED_IDS, selectedIds).apply();
    }*/

}
