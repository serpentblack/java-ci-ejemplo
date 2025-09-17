# java-ci-ejemplo

Proyecto Java mínimo (Maven) con **CI para cualquier rama** y **CD**:

- **CI**: `.github/workflows/ci.yml` — compila y ejecuta pruebas en cada `push`/`pull_request`.
- **CD Delivery**: `.github/workflows/release.yml` — al crear un tag `v*` (ej. `v1.0.0`) publica el **JAR** en *Releases*.
- **CD Deployment (Render)**: `.github/workflows/deploy-render.yml` — al crear `v*` dispara el **Deploy Hook** de Render.

## Estructura
```
.
├─ .github/workflows/
│  ├─ ci.yml
│  ├─ release.yml
│  └─ deploy-render.yml
├─ pom.xml
├─ Dockerfile           # opcional
└─ src/
   ├─ main/java/com/demo/App.java
   └─ test/java/com/demo/AppTest.java
```

## Uso rápido
1. Crea un repo en GitHub y sube estos archivos.
2. **CI** corre automáticamente al hacer `git push` en cualquier rama.
3. **Release (Delivery)**:
   ```bash
   git tag -a v1.0.0 -m "Release 1.0.0"
   git push origin v1.0.0
   ```
   Verás el JAR en la pestaña *Releases*.
4. **Deployment a Render** (opcional):
   - En Render, crea tu Web Service y copia el **Deploy Hook URL** (Settings).
   - En GitHub → *Settings → Secrets and variables → Actions* crea el secreto `RENDER_DEPLOY_HOOK_URL` con esa URL.
   - Al crear `v1.0.0`, el workflow dispara el redeploy en Render.
