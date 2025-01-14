kubectl apply -f postgres-statefulset-service.yml
kubectl apply -f app-deployment-service.yml

minikube service app-service --url
--к url добавить "/spring_course_mvc_hibernate_aop/"

Ура вы получили доступ к приложению

Можно перенаправить порт командой
kubectl port-forward service/app-service 8080:8080
Теперь можно подключиться через
http://localhost:8080/spring_course_mvc_hibernate_aop/


-------------------------------------------------------------------------------


Что бы подключиться по IP-хоста нужно установить Ingress Controller для маршрутиризации
запросов из вне к кластерам kubernetes (НУЖЕН ДОМЕН)
1.Установите Ingress Controller:
    kubectl apply -f https://raw.githubusercontent.com/kubernetes/ingress-nginx/main/deploy/static/provider/cloud/deploy.yaml
2.Создайте файл ingress.yaml (пример ниже)
apiVersion: networking.k8s.io/v1
kind: Ingress
metadata:
  name: spring-course-ingress
spec:
  rules:
  - host: (НУЖЕН ДОМЕН)
    http:
      paths:
      - path: /spring_course_mvc_hibernate_aop
        pathType: Prefix
        backend:
          service:
            name: app-service
            port:
              number: 8080
3.Применить
kubectl apply -f ingress.yaml