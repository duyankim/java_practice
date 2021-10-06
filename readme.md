# Spring CRUD 게시판 프로젝트

## 기능
- 게시판별 게시글 조회
- 게시글 작성
- 게시글 수정
- 게시글 삭제

## 적용 기술
- Spring Framework(Maven)
- JPA
- Lombok
- Thymeleaf
- MySQL
- Bootstrap
- Tinymce Editor library

## 폴더구조
```
C:.
│  .classpath
│  .gitignore
│  .project
│  mvnw
│  mvnw.cmd
│  pom.xml
│
├─.mvn
│  └─wrapper
│          maven-wrapper.jar
│          maven-wrapper.properties
│          MavenWrapperDownloader.java
│
├─.settings
│      org.eclipse.jdt.core.prefs
│
└─src
    ├─main
    │  ├─java
    │  │  └─kr
    │  │      └─ac
    │  │          └─kopo
    │  │              └─kopo03
    │  │                  │  BoardApplication.java
    │  │                  │  SpringBoardApplication.java
    │  │                  │
    │  │                  ├─controller
    │  │                  │      BoardController.java
    │  │                  │      BoardItemController.java
    │  │                  │
    │  │                  ├─domain
    │  │                  │      Board.java
    │  │                  │      BoardItem.java
    │  │                  │      User.java
    │  │                  │
    │  │                  ├─repository
    │  │                  │      BoardItemRepository.java
    │  │                  │      BoardRepository.java
    │  │                  │
    │  │                  └─service
    │  │                          BoardItemService.java
    │  │                          BoardItemServiceImpl.java
    │  │                          BoardService.java
    │  │                          BoardServiceImpl.java
    │  │
    │  └─resources
    │      │  application.properties
    │      │
    │      ├─static
    │      │  ├─css
    │      │  │      login.css
    │      │  │      search.css
    │      │  │      styles.css
    │      │  │      writeComment.css
    │      │  │
    │      │  └─js
    │      │          scripts.js
    │      │          textEditor.js
    │      │
    │      └─templates
    │          │  index.html
    │          │  login.html
    │          │  postlist.html
    │          │  postsearch.html
    │          │  postupdate.html
    │          │  postview.html
    │          │  postwrite.html
    │          │
    │          └─fragments
    │                  footer.html
    │                  head.html
    │                  header.html
    │                  nav.html
    │                  scripts.html
    │
    └─test
        └─java
            └─kr
                └─ac
                    └─kopo
                        └─kopo03
                            │  BoardApplicationTests.java
                            │
                            ├─controller
                            │      BoardControllerTest.java
                            │
                            └─repository
                                    BoardItemRepositoryTest.java
                                    BoardRepositoryTest.java
```