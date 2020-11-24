package kr.hs.emirim.s2019s33.mirimjisik;

public class PostList {
    private String title, image, contents, grade, publisher, subject;

    //생성자메소드
    public PostList(String title, String image, String contents, String grade, String publisher, String subject){
        this.title = title;
        this.image = image;
        this.contents = contents;
        this.grade = grade;
        this.publisher = publisher;
        this.subject = subject;
    }

    //getter & setter
    public String getTitle() { return title; }
    public String getImage() { return image; }
    public String getContents() { return contents; }
    public String getGrade() { return grade; }
    public String getPublisher() { return publisher; }
    public String getSubject() { return subject; }

    public void setTitle(String title) { this.title = title; }
    public void setImage(String image) { this.image = image; }
    public void setContents(String contents) { this.contents = contents; }
    public void setGrade(String grade) { this.grade = grade; }
    public void setPublisher(String publisher) { this.publisher = publisher; }
    public void setSubject(String subject) { this.subject = subject; }
}
