import React from 'react';
import { BookOpen, Users, BarChart2, Settings, LayoutDashboard, Book, User, PieChart } from 'lucide-react'; // Добавил больше иконок для разнообразия
import Dashboard from './Dashboard';
import BookCatalog from './BookCatalog';

// Заглушки для компонентов
const UsersPage = () => (
    <div className="bg-white/90 backdrop-blur-sm p-6 rounded-2xl shadow-2xl border-2 border-purple-200">
        <h3 className="text-2xl font-bold bg-gradient-to-r from-purple-600 to-pink-600 bg-clip-text text-transparent mb-4" style={{ background: 'linear-gradient(to right, #9333ea, #db2777)', WebkitBackgroundClip: 'text', WebkitTextFillColor: 'transparent', backgroundClip: 'text' }}>
            Читатели
        </h3>
        <p className="text-pink-600" style={{ color: '#db2777' }}>Список читателей библиотеки</p>
    </div>
);

const ReportsPage = () => (
    <div className="bg-white/90 backdrop-blur-sm p-6 rounded-2xl shadow-2xl border-2 border-purple-200">
        <h3 className="text-2xl font-bold bg-gradient-to-r from-purple-600 to-pink-600 bg-clip-text text-transparent mb-4" style={{ background: 'linear-gradient(to right, #9333ea, #db2777)', WebkitBackgroundClip: 'text', WebkitTextFillColor: 'transparent', backgroundClip: 'text' }}>
            Отчеты
        </h3>
        <p className="text-pink-600" style={{ color: '#db2777' }}>Аналитика и отчеты</p>
    </div>
);

const SettingsPage = () => (
    <div className="bg-white/90 backdrop-blur-sm p-6 rounded-2xl shadow-2xl border-2 border-purple-200">
        <h3 className="text-2xl font-bold bg-gradient-to-r from-purple-600 to-pink-600 bg-clip-text text-transparent mb-4" style={{ background: 'linear-gradient(to right, #9333ea, #db2777)', WebkitBackgroundClip: 'text', WebkitTextFillColor: 'transparent', backgroundClip: 'text' }}>
            Настройки
        </h3>
        <p className="text-pink-600" style={{ color: '#db2777' }}>Настройки системы</p>
    </div>
);

// Структура навигации
const navItems = [
    // Используем разные иконки для каждой секции, чтобы они выглядели уникально
    { name: 'Обзор', icon: LayoutDashboard, component: Dashboard },
    { name: 'Каталог Книг', icon: Book, component: BookCatalog },
    { name: 'Читатели', icon: User, component: UsersPage },
    { name: 'Отчеты', icon: PieChart, component: ReportsPage },
    { name: 'Настройки', icon: Settings, component: SettingsPage },
];

const Sidebar = ({ currentView, setView }) => {
    // Массив цветов для кнопок навигации - все розово-фиолетовые
    const buttonColors = [
        { bg: 'bg-gradient-to-r from-purple-500 to-pink-500', hover: 'hover:from-purple-600 hover:to-pink-600', shadow: 'shadow-purple-500/50' },
        { bg: 'bg-gradient-to-r from-pink-500 to-purple-500', hover: 'hover:from-pink-600 hover:to-purple-600', shadow: 'shadow-pink-500/50' },
        { bg: 'bg-gradient-to-r from-purple-600 to-pink-600', hover: 'hover:from-purple-700 hover:to-pink-700', shadow: 'shadow-purple-600/50' },
        { bg: 'bg-gradient-to-r from-pink-600 to-purple-600', hover: 'hover:from-pink-700 hover:to-purple-700', shadow: 'shadow-pink-600/50' },
        { bg: 'bg-gradient-to-r from-purple-500 to-pink-500', hover: 'hover:from-purple-600 hover:to-pink-600', shadow: 'shadow-purple-500/50' },
    ];

    return (
        <div 
            className="w-64 h-screen bg-white/90 backdrop-blur-lg shadow-2xl p-6 border-r-4 border-purple-500 flex flex-col font-sans"
            style={{
                width: '256px',
                height: '100vh',
                background: 'rgba(255, 255, 255, 0.9)',
                padding: '1.5rem',
                borderRight: '4px solid #9333ea',
                display: 'flex',
                flexDirection: 'column',
                fontFamily: 'Inter, Arial, sans-serif',
                boxShadow: '0 25px 50px -12px rgba(0, 0, 0, 0.25)'
            }}
        >
            <h1 
                className="text-3xl font-extrabold bg-gradient-to-r from-purple-600 via-pink-600 to-blue-600 bg-clip-text text-transparent mb-10 tracking-wider"
                style={{
                    fontSize: '1.875rem',
                    fontWeight: '800',
                    background: 'linear-gradient(to right, #9333ea, #db2777, #2563eb)',
                    WebkitBackgroundClip: 'text',
                    WebkitTextFillColor: 'transparent',
                    backgroundClip: 'text',
                    marginBottom: '2.5rem',
                    letterSpacing: '0.05em'
                }}
            >
                Libris Flow
            </h1>
            <nav className="flex-grow space-y-3">
                {navItems.map((item, index) => {
                    const isActive = currentView === item.name;
                    const colors = buttonColors[index % buttonColors.length];
                    const gradientColors = [
                        ['#a855f7', '#ec4899'], // purple to pink
                        ['#ec4899', '#a855f7'], // pink to purple
                        ['#9333ea', '#db2777'], // deep purple to pink
                        ['#db2777', '#9333ea'], // pink to deep purple
                        ['#a855f7', '#ec4899'], // purple to pink
                    ];
                    const [colorFrom, colorTo] = gradientColors[index % gradientColors.length];
                    
                    return (
                        <button
                            key={item.name}
                            onClick={() => setView(item.name)}
                            className={`flex items-center w-full p-3 rounded-xl transition-all duration-300 font-medium text-lg transform
                                ${isActive
                                ? `${colors.bg} text-white shadow-lg ${colors.shadow} scale-105` 
                                : `bg-white/70 text-gray-700 ${colors.hover} hover:text-white hover:shadow-md hover:scale-105`
                            }`}
                            style={isActive ? {
                                background: `linear-gradient(to right, ${colorFrom}, ${colorTo})`,
                                color: 'white',
                                boxShadow: '0 10px 15px -3px rgba(0, 0, 0, 0.1), 0 4px 6px -2px rgba(0, 0, 0, 0.05)',
                                transform: 'scale(1.05)'
                            } : {
                                background: 'rgba(255, 255, 255, 0.7)',
                                color: '#9333ea',
                                fontWeight: '600',
                                backgroundImage: 'linear-gradient(to right, #9333ea, #db2777)',
                                WebkitBackgroundClip: 'text',
                                WebkitTextFillColor: 'transparent',
                                backgroundClip: 'text'
                            }}
                        >
                            <item.icon className="w-6 h-6 mr-3" style={{ width: '24px', height: '24px', marginRight: '0.75rem' }} />
                            {item.name}
                        </button>
                    );
                })}
            </nav>
        </div>
    );
};

const App = () => {
    const [currentView, setCurrentView] = React.useState('Обзор');

    const CurrentComponent = navItems.find(item => item.name === currentView)?.component || Dashboard;

    try {
        return (
            <div 
                className="flex min-h-screen font-sans" 
                style={{ 
                    minHeight: '100vh', 
                    width: '100%',
                    display: 'flex',
                    background: 'linear-gradient(135deg, #667eea 0%, #764ba2 25%, #f093fb 50%, #4facfe 75%, #00f2fe 100%)',
                    backgroundSize: '400% 400%',
                    animation: 'gradientShift 15s ease infinite'
                }}
            >
                <Sidebar currentView={currentView} setView={setCurrentView} />

                <main 
                    className="flex-1 p-8 overflow-y-auto" 
                    style={{ 
                        flex: 1, 
                        padding: '2rem',
                        overflowY: 'auto'
                    }}
                >
                    <header className="mb-8" style={{ marginBottom: '2rem' }}>
                        <h2 
                            className="text-4xl font-bold bg-gradient-to-r from-purple-600 via-pink-600 to-blue-600 bg-clip-text text-transparent drop-shadow-lg"
                            style={{
                                fontSize: '2.25rem',
                                fontWeight: '700',
                                background: 'linear-gradient(to right, #9333ea, #db2777)',
                                WebkitBackgroundClip: 'text',
                                WebkitTextFillColor: 'transparent',
                                backgroundClip: 'text'
                            }}
                        >
                            {currentView}
                        </h2>
                    </header>

                    <CurrentComponent />
                </main>
            </div>
        );
    } catch (error) {
        console.error('Error rendering App:', error);
        return (
            <div style={{ padding: '20px', color: 'red', background: 'white' }}>
                <h1>Ошибка загрузки приложения</h1>
                <p>{error.message}</p>
            </div>
        );
    }
};

export default App;