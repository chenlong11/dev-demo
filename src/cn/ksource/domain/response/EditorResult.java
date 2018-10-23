package cn.ksource.domain.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class EditorResult {
    private Integer error;
    private String message;
    private String url;

    {
        error = 0;
        message = "操作成功";
        url = "";
    }

    public EditorResult(String url) {
        this.url = url;
    }

    public EditorResult(Integer error, String message) {
        this.error = error;
        this.message = message;
    }

}
