# Career Copilot 🚀

**AI-Powered Job Application Tracker & Interview Preparation Platform**

Career Copilot is an intelligent application tracking and interview preparation tool designed to streamline your job search journey. From managing applications to generating AI-tailored interview prep materials, Career Copilot helps you land your dream job efficiently.

---

## 🎯 Project Origin

> *"I was applying to many jobs and wanted a tool to manage applications and generate targeted interview preparation."*

Career Copilot was built to solve the challenge of managing multiple job applications while preparing for interviews. Instead of juggling spreadsheets and scrambling for interview prep materials, this platform consolidates everything in one intelligent system.

---

## ✨ Core Features

### 📋 Job Application Tracking
- **Centralized Application Dashboard** - Track all job applications in one place
- **Application Status Management** - Monitor application progress (Applied, Interview Scheduled, Offer, Rejected, etc.)
- **Application Timeline** - View complete history of each application
- **Recruiter Contact Management** - Store and organize recruiter information with communication history

### 🔍 Smart Job Matching & Analysis
- **Job Description Upload** - Paste any job description for AI analysis
- **Match Score** - Get a compatibility score between your profile and the job
- **Skills Gap Analysis** - Identify missing skills required for the position
- **Resume Tailoring Suggestions** - Receive AI-powered recommendations to optimize your resume for specific jobs
- **Keyword Optimization** - Ensure your resume contains relevant keywords from the job description

### 📝 AI Resume & Cover Letter Generation
- **AI Resume Tailoring** - Generate job-specific versions of your resume
- **Targeted Cover Letter Generation** - Create compelling, customized cover letters instantly
- **One-Click Customization** - Quickly adapt your application materials for each opportunity

### 🎤 Interview Preparation
- **Technical Interview Questions** - AI generates relevant technical questions based on job requirements
- **Behavioral Interview Questions** - Practice common behavioral questions with company-specific context
- **Company-Specific Questions** - Get insights about company culture and likely interview questions
- **Interview Scheduling** - Schedule and track upcoming interviews
- **Interview Notes** - Document interview experiences and feedback

### 📊 Application Analytics & Insights
- **Dashboard Metrics**
  - Total applications sent
  - Response rate
  - Interview conversion rate
  - Offer rate
  - Time-to-interview analysis
- **Trend Analysis** - Visualize patterns in your job search
- **Performance Metrics** - Track what's working and optimize your strategy

---

## 🛠 Tech Stack

### Frontend
- **React** - Dynamic, component-based UI
- **Redux/Context API** - State management
- **Tailwind CSS** - Modern, responsive styling

### Backend
- **Spring Boot** - Java-based REST API framework
- **Spring Data JPA** - Database ORM
- **Spring Security** - Authentication & Authorization

### Database
- **MySQL** - Reliable relational database

### AI & External APIs
- **OpenAI API** - GPT-powered content generation
  - Resume tailoring
  - Cover letter generation
  - Interview question generation
  - Job matching analysis

### DevOps & Deployment
- **Docker** - Containerization
- **CI/CD Pipeline** - Automated testing and deployment
- **AWS** - Cloud deployment (EC2, S3, RDS)

### Authentication
- **JWT Tokens** - Secure API authentication
- **OAuth 2.0** - Social login support

---

## 🚀 Quick Start

### Prerequisites
- Node.js 16+
- Java 17+
- MySQL 8.0+
- Docker & Docker Compose
- Git

### Installation

1. **Clone the repository**
```bash
git clone https://github.com/yourusername/career-copilot.git
cd career-copilot
```

2. **Setup Backend**
```bash
cd backend

# Configure MySQL
./scripts/mysql.sh start

# Build the project
./mvnw clean install

# Run the server
./mvnw spring-boot:run
```

The backend will be available at `http://localhost:8080/api`

3. **Setup Frontend**
```bash
cd frontend

# Install dependencies
npm install

# Start development server
npm start
```

The frontend will be available at `http://localhost:3000`

---

## 📖 Usage Guide

### 1. Create an Account
- Sign up with email or OAuth login
- Complete your profile with resume and career preferences

### 2. Track Job Applications
- Add new applications manually or import from job board exports
- Update application status as you progress through hiring pipeline
- Store recruiter contact information

### 3. Upload Job Descriptions
- Paste a job description into the "Smart Analysis" tool
- AI analyzes the role and returns:
  - Compatibility match score
  - Required skills vs. your skills
  - Suggested resume edits
  - Cover letter tailored to the role

### 4. Prepare for Interviews
- Generate technical, behavioral, and company-specific questions
- Review your tailored resume for the position
- Schedule interviews and set reminders
- Document interview experiences and feedback

### 5. Review Analytics
- Monitor your application metrics on the dashboard
- Track response rates and interview conversion
- Identify patterns to optimize your strategy

---

## 📁 Project Structure

```
career-copilot/
├── backend/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/careercopilot/
│   │   │   │   ├── controller/         # REST endpoints
│   │   │   │   ├── service/            # Business logic
│   │   │   │   ├── repository/         # Data access
│   │   │   │   ├── model/              # Entity classes
│   │   │   │   └── config/             # Configuration
│   │   │   └── resources/
│   │   │       └── application.properties
│   │   └── test/
│   ├── pom.xml
│   └── Dockerfile
├── frontend/
│   ├── src/
│   │   ├── components/                 # React components
│   │   ├── pages/                      # Page components
│   │   ├── services/                   # API services
│   │   ├── store/                      # State management
│   │   └── App.js
│   ├── package.json
│   └── Dockerfile
├── scripts/
│   └── mysql.sh                        # Database control
└── README.md
```

---

## 🔧 Configuration

### Backend Configuration (application.properties)
```properties
# MySQL Database
spring.datasource.url=jdbc:mysql://localhost:3306/career_copilot
spring.datasource.username=root
spring.datasource.password=your_password

# OpenAI API
openai.api.key=your_openai_api_key

# JWT
jwt.secret=your_jwt_secret
jwt.expiration=86400000
```

### Environment Variables
```bash
# Frontend (.env)
REACT_APP_API_URL=http://localhost:8080/api
REACT_APP_OPENAI_KEY=your_openai_key

# Backend (.env)
SPRING_DATASOURCE_URL=jdbc:mysql://localhost:3306/career_copilot
OPENAI_API_KEY=your_openai_api_key
JWT_SECRET=your_jwt_secret
```

---

## 🐳 Docker Deployment

### Build and Run with Docker Compose
```bash
docker-compose up --build
```

This will start:
- MySQL database
- Spring Boot backend
- React frontend

---

## 🧪 Testing

### Backend Tests
```bash
cd backend
./mvnw test
```

### Frontend Tests
```bash
cd frontend
npm test
```

---

## 🚢 Deployment

### AWS Deployment
1. **Database** - AWS RDS (MySQL)
2. **Backend** - AWS EC2 or Elastic Beanstalk
3. **Frontend** - AWS S3 + CloudFront
4. **CI/CD** - GitHub Actions to AWS

### Steps
```bash
# Build production images
docker build -t career-copilot-backend:latest backend/
docker build -t career-copilot-frontend:latest frontend/

# Push to Docker Registry
docker push your-registry/career-copilot-backend:latest
docker push your-registry/career-copilot-frontend:latest

# Deploy to AWS
aws ecs update-service --cluster career-copilot --service backend --force-new-deployment
```

---

## 📱 API Endpoints

### Authentication
- `POST /api/auth/register` - Register new user
- `POST /api/auth/login` - Login
- `POST /api/auth/refresh` - Refresh JWT token

### Applications
- `GET /api/applications` - Get all applications
- `POST /api/applications` - Create new application
- `PUT /api/applications/{id}` - Update application
- `DELETE /api/applications/{id}` - Delete application

### Job Analysis
- `POST /api/jobs/analyze` - Analyze job description
- `POST /api/jobs/match` - Get job match score
- `POST /api/resume/tailor` - Generate tailored resume

### Interview Prep
- `POST /api/interview/questions/technical` - Generate technical questions
- `POST /api/interview/questions/behavioral` - Generate behavioral questions
- `POST /api/interview/schedule` - Schedule interview

### Analytics
- `GET /api/analytics/dashboard` - Get dashboard metrics
- `GET /api/analytics/trends` - Get trend data

---

## 🤝 Contributing

Contributions are welcome! Please follow these steps:

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit changes (`git commit -m 'Add AmazingFeature'`)
4. Push to branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

---

## 📋 Roadmap

- [ ] Mobile app (React Native)
- [ ] LinkedIn integration
- [ ] Job board integrations (Indeed, LinkedIn, Glassdoor)
- [ ] Salary negotiation AI
- [ ] Team collaboration features
- [ ] Interview video recording and playback
- [ ] Multi-language support

---

## ⚠️ Important Notes

### OpenAI API Key
- Sign up at [OpenAI Platform](https://platform.openai.com)
- Add your API key to environment variables
- Monitor usage to manage costs

### Database
- Start MySQL before running the backend
- Use `./scripts/mysql.sh start` to start the database
- Use `./scripts/mysql.sh stop` to stop the database

---

## 📄 License

This project is licensed under the MIT License - see LICENSE file for details.

---

## 👨‍💻 Author

**Career Copilot Development Team**

Built with ❤️ to help job seekers succeed

---

## 📞 Support

For questions, issues, or suggestions:
- Open an issue on GitHub
- Check existing documentation
- Review FAQ section

---

## 🙏 Acknowledgments

- OpenAI for GPT API
- Spring Boot community
- React ecosystem
- All contributors and users

---

## 📈 Performance

- **Resume Analysis**: < 2 seconds
- **Interview Question Generation**: < 3 seconds
- **Job Matching**: < 1 second
- **Database Queries**: Optimized with indexes

---

**Happy Job Hunting! 🎯**
