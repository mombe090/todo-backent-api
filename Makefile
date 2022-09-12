run_promentheus:
	docker rm prometheus || true && \
	docker run --name prometheus \
		-p 9090:9090 \
        -v /Users/macbook/Documents/WorkStation/tutos/devops-series/todo-backent-api/deploiement/prometheus/prometheus.yml:/opt/bitnami/prometheus/conf/prometheus.yml \
        bitnami/prometheus:latest

run_grafana:
	docker rm grafana || true && \
    docker run -d --name=grafana -p 3000:3000 grafana/grafana


