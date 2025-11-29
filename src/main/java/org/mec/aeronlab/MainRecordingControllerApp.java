package org.mec.aeronlab;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.mec.aeronlab.config.ArchiveModule;
import org.mec.aeronlab.record.RecordingController;

public class MainRecordingControllerApp
{
    public static void main(String[] args)
    {
        Injector injector = Guice.createInjector(new ArchiveModule());
        RecordingController recordingController = injector.getInstance(RecordingController.class);

        String[] channels = {
                "aeron:udp?endpoint=224.0.1.1:40123|interface=192.168.1.107"
        };

        int[] streamIds = {10};

        for (int i = 0; i < channels.length; i++)
        {
            recordingController.startRecording(channels[i], streamIds[i]);
            System.out.println(("Started recording: " + channels[i] + " / streamId=" + streamIds[i]));
        }

        System.out.println("All recrodings started");
        System.out.println("This is great!");
        System.out.println("This is awesome!");
        System.out.println("This is wonderful!");
        System.out.println("This is sunny!");
        System.out.println("This is blue sky skiing!");
        System.out.println("This is excellent swimming!");
        System.out.println("This is wholesome!");
    }
}
