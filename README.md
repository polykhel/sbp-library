Reusable BOM and server-side library (Java / Spring Boot)
----------------------------
[![Build Status][github-actions-build-image]][github-actions-url]

This was forked from the JHipster project. This is only intended for personal and educational use.

Reusable Bill of Materials and server-side library for Spring Boot Projects:
- sbp-dependencies
- sbp-infrastructure

To use this project:
- clone this project
- run `./mvnw clean install -Dgpg.skip=true`, on Windows run `.\mvnw.cmd clean install -D"gpg.skip=true"`

[github-actions-build-image]: https://github.com/polykhel/sbp-parent/workflows/Build/badge.svg
[github-actions-url]: https://github.com/polykhel/sbp-parent/actions

## Analysis

[![sonar-quality-gate][sonar-quality-gate]][sonar-url] [![sonar-coverage][sonar-coverage]][sonar-url] [![sonar-bugs][sonar-bugs]][sonar-url] [![sonar-vulnerabilities][sonar-vulnerabilities]][sonar-url]

[sonar-url]: https://sonarcloud.io/dashboard?id=polykhel_sbp-parent
[sonar-quality-gate]: https://sonarcloud.io/api/project_badges/measure?project=polykhel_sbp-parent&metric=alert_status
[sonar-coverage]: https://sonarcloud.io/api/project_badges/measure?project=polykhel_sbp-parent&metric=coverage
[sonar-bugs]: https://sonarcloud.io/api/project_badges/measure?project=polykhel_sbp-parent&metric=bugs
[sonar-vulnerabilities]: https://sonarcloud.io/api/project_badges/measure?project=polykhel_sbp-parent&metric=vulnerabilities