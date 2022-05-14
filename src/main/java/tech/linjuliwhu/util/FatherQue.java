package tech.linjuliwhu.util;

public class FatherQue {
    private String queTitle;
    private String queAns;

    public FatherQue(String _queTitle, String _queAns) {
        queTitle = _queTitle;
        queAns = _queAns;
    }

    public String getQueTitle() {
        return queTitle;
    }

    public void setQueTitle(String queTitle) {
        this.queTitle = queTitle;
    }

    public String getQueAns() {
        return queAns;
    }

    public void setQueAns(String queAns) {
        this.queAns = queAns;
    }
}
