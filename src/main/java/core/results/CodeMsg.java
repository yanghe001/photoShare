package core.results;

public class CodeMsg {
    private int code;
    private String msg;
    private CodeMsg(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    //通用的错误码 101XX
    public static CodeMsg SUCCESS = new CodeMsg(0, "success");
    public static CodeMsg ERROR = new CodeMsg(1, "failure");
    public static CodeMsg LOGIN_USER_SUCCESS=new CodeMsg(1,"登录成功！");
    public static CodeMsg LOGIN_ADMIN_SUCCESS=new CodeMsg(2,"登录成功！");
    public static CodeMsg NOT_LOGIN=new CodeMsg(3,"请先登录哦亲！");
    public static CodeMsg SERVER_ERROR = new CodeMsg(100101, "服务端异常");
    public static CodeMsg BIND_ERROR = new CodeMsg(100102, "参数校验异常：%s");
    //登录模块 201XX
    public static CodeMsg SESSION_ERROR = new CodeMsg(20101, "Session不存在或者已经失效");
    public static CodeMsg NAME_NOT_EXIST = new CodeMsg(20102, "登录名不存在");
    public static CodeMsg PASSWORD_ERROR = new CodeMsg(20103, "密码错误");
    //注册模块 301XX
    public static CodeMsg REGISTER_NAME_EXIT= new CodeMsg(30101, "登录名已存在");
    //上传错误
    public static CodeMsg UPLOAD_ERROR= new CodeMsg(30201, "文件上传错误：%s");
    //喜欢错误
    public static CodeMsg LOVE_ERROR= new CodeMsg(30301, "喜欢错误：%s");
    //分类错误
    public static CodeMsg SORT_ERROR= new CodeMsg(30401, "分类错误：%s");
    public CodeMsg fillArgs(Object... args) {
        int code = this.code;
        String message = String.format(this.msg, args);
        return new CodeMsg(code, message);
    }

    public void setCode(int code) {
        this.code = code;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
    public int getCode() {
        return code;
    }
    public String getMsg() {
        return msg;
    }

    @Override
    public String toString() {
        return "CodeMsg{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }
}
