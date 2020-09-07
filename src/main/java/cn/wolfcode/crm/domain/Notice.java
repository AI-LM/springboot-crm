package cn.wolfcode.crm.domain;

import cn.wolfcode.crm.mapper.NoticeMapper;
import cn.wolfcode.crm.service.INoticeService;
import cn.wolfcode.crm.util.UserContext;
import com.alibaba.fastjson.JSON;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Date;
import java.util.HashMap;
import java.util.List;


@Getter
@Setter
@ToString
public class Notice {
 private Long id;
 private Employee employee;
 private String title;
 private Date pubDate;
 private String content;
// private boolean  read;
 private String noticeId;

 public String getNoticeId() {
  return noticeId==null?"未读":"已读";
 }

 public String getJson() {
  HashMap map = new HashMap<>();
  map.put("id", id);
  map.put("employeeId", employee.getId());
  map.put("title", title);
  map.put("pubDate", pubDate);
  map.put("content", content);
  map.put("employeeName", employee.getName());
  return JSON.toJSONString(map);
 }


}