import React from 'react';
import { BookOpen, TrendingUp, Users } from 'lucide-react';

const MetricCard = ({ title, value, color, icon: Icon }) => (
    // Улучшенные стили карточек: мягкая тень, плавные переходы, эффект подъема при наведении
    <div className="bg-white p-6 rounded-2xl shadow-xl transition-all duration-300 ease-in-out
                    transform hover:shadow-2xl hover:-translate-y-1">
        <div className={`flex items-center justify-between p-3 rounded-xl`}
             style={{ backgroundColor: `${color}1A` /* Добавляем прозрачность к цвету */ }}>
            <Icon className={`w-8 h-8`} style={{ color }} /> {/* Иконка с основным цветом */}
        </div>
        <p className="text-sm text-gray-500 mt-4">{title}</p>
        <h3 className="text-4xl font-extrabold text-gray-900 mt-1 font-sans">{value}</h3>
    </div>
);

const Dashboard = () => {
    return (
        <div className="space-y-8">
            {/* Секция ключевых метрик */}
            <div className="grid grid-cols-1 md:grid-cols-4 gap-6">
                <MetricCard
                    title="Всего Книг"
                    value="12,500"
                    color="#3F51B5" // Индиго
                    icon={BookOpen}
                />
                <MetricCard
                    title="Книг Выдано"
                    value="850"
                    color="#FF7043" // Коралл (Акцент!)
                    icon={TrendingUp}
                />
                <MetricCard
                    title="Просрочено"
                    value="45"
                    color="#EF4444" // Красный для критичности
                    icon={BookOpen}
                />
                <MetricCard
                    title="Новых Читателей (Месяц)"
                    value="120"
                    color="#10B981" // Зеленый для роста
                    icon={Users}
                />
            </div>

            {/* Другие виджеты (например, график активности) */}
            <div className="bg-white p-6 rounded-2xl shadow-lg">
                <h3 className="text-xl font-semibold mb-4 text-gray-800 font-sans">Активность выдачи за 6 месяцев</h3>
                <div className="h-64 flex items-center justify-center text-gray-400 border-2 border-dashed border-gray-200 rounded-lg">
                    {/* Здесь будет код для красивого графика */}
                    Нет данных для графика
                </div>
            </div>
        </div>
    );
};

export default Dashboard;