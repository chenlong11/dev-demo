package cn.ksource.util;

import java.io.File;
import java.util.Arrays;
import java.util.Calendar;

public class UploadUtil {

    private static String[] extensions = {"xls", "xlsx", "ppt", "pptx", "doc", "docx", "txt", "pdf", "7z", "rar", "zip", "gif", "jpg", "jpeg", "png", "vsd", "mpp"};

    /**
     * 获取相对路径
     *
     * @return
     */
    public static String getRelativePath() {
        Calendar calendar = Calendar.getInstance();
        String year = String.valueOf(calendar.get(Calendar.YEAR));
        String month = String.valueOf(calendar.get(Calendar.MONTH) + 1);
        String day = String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));
        String relativePath = "/attchment/" + year + "/" + month + "/" + day + "/";
        File fileDirectory = new File(getApplicationPath() + relativePath);
        if (!fileDirectory.exists()) {
            fileDirectory.mkdirs();
        }
        return relativePath;
    }

    /**
     * 获取相对路径
     *
     * @return
     */
    public static String getRelativeFileName(String ext) {
        return getRelativePath() + String.valueOf(UidUtils.getUID()) + "." + ext;
    }

    /**
     * 获取绝对路径
     *
     * @return
     */
    public static String getApplicationPath() {
        return UploadUtil.class.getResource("/")
                .getPath()
                .replace("/WEB-INF/classes/", "");
    }

    /**
     * 检测扩展名
     *
     * @param ext
     */
    public static boolean isAllowExtension(String ext) {
        if (!Arrays.asList(extensions).contains(ext)) {
            return false;
        } else {
            return true;
        }
    }

    public static String getFileExt(String fileName) {
        return fileName.substring(fileName.lastIndexOf(".") + 1);
    }
}