# Git 명령어 정리

1. staging과 commit을 동시에
   > git commit -am "massage"
2. branch 생성
   > git branch (branch name)
3. 현재 작업 branch 변경
   > git switch branch
4. branch 생성과 변경 동시에
   > git swich -c (branch name)
5. 과거 시점으로 돌아가기
   > git checkout (commit ID)
6. 과거 시점 오류 고친 후 새 branch 생성하여 commit
   > git switch -c (new branch name)
7. 다른 branch 내용과 합치기
   > git merge (branch name)
