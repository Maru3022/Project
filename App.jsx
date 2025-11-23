import React from 'react';
import { BookOpen, Users, BarChart2, Settings, LayoutDashboard, Book, User, PieChart } from 'lucide-react'; // Добавил больше иконок для разнообразия
import Dashboard from './Dashboard';
import BookCatalog from './BookCatalog';

// Структура навигации
const navItems = [
    // Используем разные иконки для каждой секции, чтобы они выглядели уникально
    { name: 'Обзор', icon: LayoutDashboard, component: Dashboard },
    { name: 'Каталог Книг', icon: Book, component: BookCatalog },
    { name: 'Читатели', icon: User, component: Users }, // Иконка для читателей
    { name: 'Отчеты', icon: PieChart, component: BarChart2 }, // Иконка для отчетов
    { name: 'Настройки', icon: Settings, component: Settings },
];

const Sidebar = ({ currentView, setView }) => (
    <div className="w-64 h-screen bg-white shadow-lg p-6 border-r border-gray-100 flex flex-col font-sans">
        <h1 className="text-3xl font-extrabold text-indigo-primary mb-10 tracking-wider">
            Libris Flow
        </h1>
        <nav className="flex-grow space-y-3">
            {navItems.map((item) => {
                const isActive = currentView === item.name;
                return (
                    <button
                        key={item.name}
                        onClick={() => setView(item.name)}
                        className={`flex items-center w-full p-3 rounded-xl transition-all duration-200 font-medium text-lg
                            ${isActive
                            ? 'bg-indigo-primary text-white shadow-md shadow-indigo-primary/40 transform scale-105' // Активная кнопка: сильный акцент, небольшой подъем
                            : 'text-gray-text hover:bg-indigo-50 hover:text-indigo-primary' // Неактивная: мягкий hover
                        }`}
                    >
                        <item.icon className="w-6 h-6 mr-3" />
                        {item.name}
                    </button>
                );
            })}
        </nav>
        {/* Опционально: можно добавить футер сайдбара */}
        {/* <div className="mt-8 pt-4 border-t border-gray-100 text-sm text-gray-400">
            © 2025 Libris Flow
        </div> */}
    </div>
);

const App = () => {
    const [currentView, setCurrentView] = React.useState('Обзор');

    const CurrentComponent = navItems.find(item => item.name === currentView)?.component || Dashboard;

    return (
        <div className="flex bg-gray-bg min-h-screen font-sans">
            <Sidebar currentView={currentView} setView={setCurrentView} />

            <main className="flex-1 p-8 overflow-y-auto">
                <header className="mb-8">
                    <h2 className="text-4xl font-bold text-gray-800">{currentView}</h2>
                </header>

                <CurrentComponent />
            </main>
        </div>
    );
};

export default App;