package general;

import io.qameta.allure.Attachment;
import java.io.File;
import java.io.IOException;

public class AllureUtils {
//    @Attachment(value = "VideoFile", type = "video/mp4", fileExtension = ".mp4")
//    public byte[] attachVideoToAllure(String videoFileLocation) {
//        File video = new File(videoFileLocation);
//        try {
//            return Files.toByteArray(video);
//        } catch (IOException e) {
//            log("attachVideoToAllure(): FAILED\n" + e.getMessage());
//            return new byte[0];
//        }
//    }

//    @Attachment(value = "Video on Failure", type = "video/mp4")
//    private byte[] getVideo(URL videoCaptureURL) {
//        try {
//            return urlFetcher.fetchWithRetry(videoCaptureURL, 4);
//        } catch (TimeoutException e) {
//            logger.error("Failed fetching URL {}.", videoCaptureURL);
//            return null;
//        }
//    }

//    @Attachment(value = "FAILED STEP", type = "video/mp4")
//    public byte[] makeVideo() throws IOException, InterruptedException {
//        return stopRecordVideoRefact();
//    }
}
