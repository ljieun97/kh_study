package com.example.bank.entity.jpa;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
//테이블 이름은 자동으로 클래스 이름으로 생성되는데 너무 기니까 지정해줌
@Table(name = "jpa_member")
public class VueJpaMemberWithAuth {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_no")
    private Long memberNo;

    @Column(length = 32, nullable = false)
    private String userId;

    @Column(length = 32, nullable = false)
    private String password;

    @CreationTimestamp
    private Date regDate;

    @UpdateTimestamp
    private Date updDate;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "member_no")
    private List<VueJpaMemberAuth> authList;

    public VueJpaMemberWithAuth (String userId, String password) {
        this.userId = userId;
        this.password = password;
    }

    public void addAuth (VueJpaMemberAuth auth) {
        if (authList == null) {
            authList = new ArrayList<VueJpaMemberAuth>();
        }
        authList.add(auth);
    }

    public void clearAuthList() {
        authList.clear();
    }
}
