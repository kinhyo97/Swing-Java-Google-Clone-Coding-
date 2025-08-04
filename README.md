<img width="1262" height="707" alt="image" src="https://github.com/user-attachments/assets/0b9499ad-2c48-4184-88e4-47bf11a2bf6b" />





# 🌐 Swing Java Google Clone

Java Swing을 활용한 Google 메인 페이지 클론 프로젝트입니다.

---



## 📌 주요 기능

- ✅ Google 메인 페이지 UI 클론 구현 (어두운 테마)
- ✅ 라운드 검색바 및 플레이스홀더 기능
- ✅ 원형 아이콘 마스킹으로 숏컷 메뉴 구성
- ✅ 마이크, 렌즈, 검색 아이콘 포함된 검색창 UI
- ✅ `BoxLayout`, `Custom JPanel` 기반 반응형 레이아웃

---

## 🛠 기술 스택

- **Java 17**
- **Swing / AWT**
- 사용자 정의 컴포넌트 (`RoundedPanel`, `RoundedButtonUI` 등)

---

## 🎨 스크린샷

<img src="https://github.com/kinhyo97/Swing-Java-Google-Clone-Coding-/assets/your_image.png" width="700"/>

---

## 📁 프로젝트 구조

```bash
src/
└── org/example/ui/
    ├── home/         # 메인 홈 화면 UI 구성
    ├── common/       # RoundedPanel 등 공용 컴포넌트
    └── Main.java     # 실행 진입점


git clone https://github.com/kinhyo97/Swing-Java-Google-Clone-Coding-.git
cd Swing-Java-Google-Clone-Coding-
javac -d out src/org/example/ui/Main.java
java -cp out org.example.ui.Main

본 프로젝트는 Java Swing 학습과 UI 레이아웃 설계 능력 향상을 위해 제작되었습니다.
실제 Google 메인 페이지의 스타일을 최대한 반영하되, Java에서 구현 가능한 선에서 클론했습니다.
