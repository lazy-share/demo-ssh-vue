package com.lazy.demo.sshvue.server.api.token;

/**
 * <p>
 * token 信息
 * </p>
 *
 * @author laizhiyuan
 * @since 2020/2/8.
 */
public class TokenAttr {


    private String username;
    private String password;
    private String salt;
    private String email;
    private Long accountId;

    public TokenAttr() {
    }

    public String getUsername() {
        return username;
    }

    public TokenAttr setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public TokenAttr setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getSalt() {
        return salt;
    }

    public TokenAttr setSalt(String salt) {
        this.salt = salt;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public TokenAttr setEmail(String email) {
        this.email = email;
        return this;
    }

    public Long getAccountId() {
        return accountId;
    }

    public TokenAttr setAccountId(Long accountId) {
        this.accountId = accountId;
        return this;
    }
}
