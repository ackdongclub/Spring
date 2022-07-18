package hello.core.singleton;

public class SingletonService {

    private static final SingletonService instance = new SingletonService();
    //자기자신을 외부에 private static으로 생성 (static은 딱 1번만 실행 되기 때문에 1개의 생성자가 생긴다)

    //public으로 열어서 객체 인스턴스가 필요하면 이 static 메서드를 통해서만 조회하도록 한다
    public static SingletonService getInstance() {
        return instance;
    }

    //생성자를 private으로 선언해서 외부에서 new 키워드를 사용한 객체 생성을 못하게 막는다
    private SingletonService() {

    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }

}
