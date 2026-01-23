# Frontend

## ☑️ Overview
- React Native를 사용한 Todo 앱 프론트엔드 구현
- 모바일 환경에서도 빠르게 화면을 구성하고, 상태 변화에 따라 UI를 효율적으로 업데이트 하기 위해 React Native를 사용



## ☑️ Feature
- useState : 할 일 목록 상태 실시간 관리
- 컴포넌트 기반 구조로 유지보수 용이
- Axios : 백엔드 API 통신



## ☑️ Components
- InputForm : 사용자 입력 폼, onSubmit으로 부모(MainScreen)에게 입력 전달
- TodoItem : 할 일 항목 표시, 삭제 및 완료 버튼 제공
- MainScreen : 화면 전체 관리, 서버 API 통신 및 상태 관리
- APP : 최상위 컴포넌트, 앱 전체 레이아웃 관리
- index.js : 앱 엔트리, AppRegistry 등록
