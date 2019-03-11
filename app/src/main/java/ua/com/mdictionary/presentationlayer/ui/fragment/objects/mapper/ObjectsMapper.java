package ua.com.mdictionary.presentationlayer.ui.fragment.objects.mapper;

import android.annotation.SuppressLint;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import ua.com.mdictionary.BR;
import ua.com.mdictionary.datalayer.network.response.ObjectResponse;
import ua.com.mdictionary.presentationlayer.ui.fragment.objects.view.adapter.ObjectItem;
import ua.com.mdictionary.presentationlayer.ui.fragment.objects.viewmodel.ObjectViewModel;

public class ObjectsMapper {

    public List<ObjectItem> mapObjects(List<ObjectResponse> objectsResponse, Set<String> selectedIds) {
        List<ObjectItem> result = new ArrayList<>();
        for (ObjectResponse object : objectsResponse) {
            if (!selectedIds.contains(String.valueOf(object.id))) {
                ObjectViewModel viewModel = new ObjectViewModel();
                viewModel.setId(String.valueOf(object.id));
                ObjectItem item = new ObjectItem(viewModel, BR.viewModel);
                result.add(item);
            }
        }
        return result;
    }

    private String formatPastTIme(long startTime) {
        Date startDate = new Date(startTime);
        Date endDate = new Date(System.currentTimeMillis());
        long msec = (endDate.getTime() - startDate.getTime());
        long secondsInMilli = 1000;
        long minutesInMilli = secondsInMilli * 60;
        long hoursInMilli = minutesInMilli * 60;
        long daysInMilli = hoursInMilli * 24;

        long elapsedDays = msec / daysInMilli;
        msec = msec % daysInMilli;

        long elapsedHours = msec / hoursInMilli;
        msec = msec % hoursInMilli;

        long elapsedMinutes = msec / minutesInMilli;
        msec = msec % minutesInMilli;

        long elapsedSeconds = msec / secondsInMilli;
        @SuppressLint("DefaultLocale") String result = String.format("%02d days %02d:%02d:%02d",
                elapsedDays,
                elapsedHours,
                elapsedMinutes,
                elapsedSeconds);
        return result;
    }

    private String formatTime(long startTime) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm dd/MM");
        String startTimeStr = sdf.format(new Date(startTime));
        return startTimeStr;
    }
}
