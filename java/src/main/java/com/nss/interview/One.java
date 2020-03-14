package com.nss.interview;

import java.security.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author liuzhiheng
 * @version 1.0
 * @date 2020/2/27 20:21
 * @describe:
 */
public class One {
    public static void main(String[] args) {

    }
    /**
     * 统计学生选的课程
     *
     * @param studentClassList
     *            学生-课程 表
     * @return 按学生id正序排序
     */
    List<Student> group(List<StudentClass> studentClassList) {
        return null;
    }
}
/**
 * 学生
 */
class Student {
    private Long id;
    // 学生选的课程数
    private Long classCount;
    // 学生选的所有课程，按选课时间倒序排序
    private List<String> classNameList;

    public void invertedOrder(){
        ArrayList<StudentClass> studentClasses = new ArrayList<>();
        Collections.sort(studentClasses,new Stu());

    }
}

/**
 * 学生选的课
 */
class StudentClass {
    private Long studentId;// 学生id
    private String className;// 课程名称
    private Timestamp createTime;// 选课时间

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }
}



class Stu implements Comparator<StudentClass> {


    @Override
    public int compare(StudentClass o1, StudentClass o2) {

        return o1.getCreateTime().getTimestamp().compareTo(o2.getCreateTime().getTimestamp());
    }

}

