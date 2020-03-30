package core.vo;

import javax.validation.constraints.NotEmpty;

public class LoginVo {
    @NotEmpty(message = "登录名不能为空")
    private String name;
    @NotEmpty(message = "密码不能为空")
    private String password;

    @Override
    public String toString() {
        return "LoginVo{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
