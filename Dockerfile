# --- СТАДИЯ 1: Сборка фронтенда (React/Vite) ---
FROM node:20-slim AS frontend-builder

# Установка рабочей директории
WORKDIR /app

# 1. Копируем только файлы для установки зависимостей (ускоряет кэш)
COPY package*.json ./

# 2. Установка зависимостей Node.js
# Используем --force, чтобы избежать проблем с конфликтами peer dependencies
RUN npm install --force

# 3. Копируем все остальные файлы фронтенда
COPY . .

# 4. Запуск сборки фронтенда (создает папку /app/dist)
# ФИНАЛЬНОЕ ИСПРАВЛЕНИЕ: Прямой вызов основного JavaScript файла Vite через 'node',
# чтобы обойти все проблемы с правами доступа или shell-скриптами в node_modules/.bin.
RUN node ./node_modules/vite/bin/vite.js build

# -------------------------------------------------------------

# --- СТАДИЯ 2: Финальный образ (Java + Фронтенд) ---
FROM eclipse-temurin:25-jre-alpine

# Установка рабочей директории для Java-приложения
WORKDIR /usr/src/app

# Копирование скомпилированных Java-классов
COPY out/production/Project /usr/src/app

# Копирование собранного фронтенда
COPY --from=frontend-builder /app/dist /usr/src/app/static

# Порт
EXPOSE 8080

# Команда запуска приложения
CMD ["java", "Main"]