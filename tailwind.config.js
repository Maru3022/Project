// tailwind.config.js
/** @type {import('tailwindcss').Config} */
module.exports = {
    // ЭТО ОЧЕНЬ ВАЖНО: Убедитесь, что Tailwind сканирует нужные файлы
    content: [
        "./index.html",
        "./*.{js,jsx,ts,tsx}", // Сканирование всех JSX/JS файлов в корне
    ],

    theme: {
        extend: {
            colors: {
                'indigo-primary': '#3F51B5',
                'indigo-light': '#5C6BC0',
                'coral-accent': '#FF7043',
                'gray-bg': '#F5F7FA',
                'gray-text': '#4B5563',
                // Яркие цвета для разноцветных кнопок
                'purple': '#9C27B0',
                'pink': '#E91E63',
                'blue': '#2196F3',
                'cyan': '#00BCD4',
                'teal': '#009688',
                'green': '#4CAF50',
                'lime': '#CDDC39',
                'yellow': '#FFEB3B',
                'orange': '#FF9800',
                'red': '#F44336',
                'deep-purple': '#673AB7',
                'amber': '#FFC107',
            },
            fontFamily: {
                sans: ['Inter', 'Arial', 'sans-serif'],
            },
            backgroundImage: {
                'gradient-radial': 'radial-gradient(var(--tw-gradient-stops))',
                'gradient-conic': 'conic-gradient(from 180deg at 50% 50%, var(--tw-gradient-stops))',
            }
        },
    },
    plugins: [],
}